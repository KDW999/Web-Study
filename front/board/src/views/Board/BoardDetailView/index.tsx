import React, { MouseEvent, useEffect, useState } from 'react'
import { Avatar, Box, Button, Card, Divider, IconButton, Input, Menu, MenuItem, Pagination, Stack, Typography } from '@mui/material'
import DragIndicatorIcon from '@mui/icons-material/DragIndicator';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import CommentOutlinedIcon from '@mui/icons-material/CommentOutlined';
import KeyboardArrowDownOutlinedIcon from '@mui/icons-material/KeyboardArrowDownOutlined';
import KeyboardArrowUpOutlinedIcon from '@mui/icons-material/KeyboardArrowUpOutlined';
import FavoriteOutlinedIcon from '@mui/icons-material/FavoriteOutlined';

import { useNavigate, useParams } from 'react-router-dom';
import { BOARD_LIST, COMMENT_LIST, LIKE_LIST } from 'src/mock';
import { Board, ICommentItem, ILikeUser, IPreviewItem, Liky, Comment } from 'src/interfaces';
import { useUserStore } from 'src/stores';
import LikeListItem from 'src/components/LikeListItem';
import CommentListItem from 'src/components/CommentListItem';
import { usePagingHook } from 'src/hooks';
import { getPageCount } from 'src/utils';
import axios, { AxiosResponse } from 'axios';
import { GetBoardResponseDto } from 'src/apis/response/board';
import ResponseDto from 'src/apis/response';
import { GET_BOARD_URL } from 'src/constants/api';

export default function BoardDetailView() {

    const [anchorElement, setAnchorElement] = useState<null | HTMLElement>(null);
    const [menuOpen, setMenuOpen] = useState<boolean>(false);
    const [menuFlag, setMenuFlag] = useState<boolean>(false);

    const [board, setBoard] = useState<Board | null>(null);

    const [likeStatus, setLikeStatus] = useState<boolean>(false);
    const [openLike, setOpenLike] = useState<boolean>(false);
    const [likeList, setLikeList] = useState<Liky[]>([]);

    const [openComment, setOpenComment] = useState<boolean>(false);

    let isLoad = false;
    const [commentList, setCommentList] = useState<Comment[]>([]);

    const { boardList, setBoardList, viewList, COUNT, pageNumber, onPageHandler } = usePagingHook(3);

    const { boardNumber } = useParams();
    const navigator = useNavigate();

    const { user } = useUserStore();

    const getBoard = () => {
        if(board) return;
        axios.get(GET_BOARD_URL(boardNumber as string))
        .then((response) => getBoardResponseHandler(response))
        .catch((error) => getBoardErrorHandler(error));
    }

    const getBoardResponseHandler = (response : AxiosResponse<any, any>) => {

        const { result, message, data} = response.data as ResponseDto<GetBoardResponseDto>
        if(!result || !data){
            alert(message);
            navigator('/');
            return;
        }

        const { board, commentList, likeList} = data;
        setBoard(board);

        //? 댓글 리스트를 3개 까지 보여주도록 하는 LOGIC
        setBoardList(commentList);
        setLikeList(likeList);

        const owner = user !== null && board.writerEmail === user.email;
        console.log(board.writerEmail);
        setMenuFlag(owner); 
    }

    const getBoardErrorHandler = (error : any) => {

        console.log(error.message);

    }

    const onMenuClickHandler = (event: MouseEvent<HTMLButtonElement>) => {
        setAnchorElement(event.currentTarget);
        setMenuOpen(true);
    }

    const onMenuCloseHandler = () => {
        setAnchorElement(null);
        setMenuOpen(false);
    }

    useEffect(() => {
        if(isLoad) return;

        //? boardNumber가 존재하는지 검증
        if (!boardNumber) {
            navigator('/');
            return;
        }

        isLoad = true; // useEffect() 2번 도는 거 방지하려면 변수 만들어서 빠져나가기

        //? BOARD_LIST에서 boardNumber에 해당하는 board를 가져옴
        // const board = BOARD_LIST.find((boardItem) => boardItem.boardNumber === parseInt(boardNumber));
        //? 검색한 결과가 존재하는지 검증
        // if (!board) {
        //     navigator('/');
        //     return;
        // }

        getBoard();
        // setLikeList(LIKE_LIST);
        // const owner = user !== null && user.nickname === board.writerNickname;
        // setMenuFlag(owner);
        // setBoard(board);
        // setBoardList(COMMENT_LIST);
    }, [])

    return (
        <Box sx={{ p: '100px 222px' }}>
            <Box>
                <Box>
                    <Typography sx={{ fontSize: '32px', fontWeight: 500 }}>{board?.boardTitle}</Typography>
                    <Box sx={{ mt: '20px', display: 'flex', justifyContent: 'space-between' }}>
                        <Box sx={{ display: 'flex', alignItems: 'center' }}>
                            <Avatar src={board?.writerProfileUrl ? board.writerProfileUrl : ''} sx={{ height: '32px', width: '32px', mr: '8px' }} />
                            <Typography sx={{ mr: '8px', fontSize: '16px', fontWeight: 500 }}>{board?.writerNickname}</Typography>
                            <Divider sx={{ mr: '8px' }} orientation='vertical' variant='middle' flexItem />
                            <Typography sx={{ fontSize: '16px', fontWeight: 400, opacity: 0.4 }}>{board?.boardWriteDatetime}</Typography>
                        </Box>
                        {menuFlag && (
                            <IconButton onClick={(event) => onMenuClickHandler(event)}>
                                <DragIndicatorIcon />
                            </IconButton>
                        )}
                        <Menu anchorEl={anchorElement} open={menuOpen} onClose={onMenuCloseHandler}>
                            <MenuItem sx={{ p: '10px 59px', opacity: 0.5 }} onClick={() => navigator(`/board/update/${board?.boardNumber}`)}>수정</MenuItem>
                            <Divider />
                            <MenuItem sx={{ p: '10px 59px', color: '#ff0000', opacity: 0.5 }}>삭제</MenuItem>
                        </Menu>
                    </Box>
                </Box>
                <Divider sx={{ mr: '40px 0px' }} />
                <Box>
                    <Typography sx={{ fontSize: '18px', fontWeight: 500, opacity: 0.7 }}>{board?.boardContent}</Typography>
                    {board?.boardImgUrl && (<Box sx={{ width: '100%', mt: '20px' }} component='img' src={board?.boardImgUrl} />)}
                </Box>
                <Box sx={{ display: 'flex', mt: '20px' }}>
                    <Box sx={{ mr: '20px', display: 'flex' }}>
                        {likeStatus ?
                            (<FavoriteOutlinedIcon sx={{ height: '24px', width: '24px', opacity: 0.8, mr: '6px', color: '#FF0000' }} onClick={() => setLikeStatus(!likeStatus)} />) :
                            (<FavoriteBorderIcon sx={{ height: '24px', width: '24px', opacity: 0.8, mr: '6px' }} onClick={() => setLikeStatus(!likeStatus)} />)
                        }

                        <Typography sx={{ fontSize: '16px', fontWeight: 500, opacity: 0.8, mr: '6px' }}>좋아요 {board?.likeCount}</Typography>
                        <IconButton sx={{ height: '24px', width: '24px' }} onClick={() => setOpenLike(!openLike)}>
                            {openLike ? (<KeyboardArrowUpOutlinedIcon />) : (<KeyboardArrowDownOutlinedIcon />)}
                        </IconButton>
                    </Box>
                    <Box sx={{ display: 'flex' }}>
                        <CommentOutlinedIcon sx={{ height: '24px', width: '24px', mr: '6px', opacity: 0.7 }} />
                        <Typography sx={{ fontSize: '16px', fontWeight: 500, opacity: 0.7, mr: '6px' }}>댓글 {board?.commentCount}</Typography>
                        <IconButton sx={{ height: '24px', width: '24px' }} onClick={() => setOpenComment(!openComment)}>
                            {openComment ? (<KeyboardArrowUpOutlinedIcon />) : (<KeyboardArrowDownOutlinedIcon />)}
                        </IconButton>
                    </Box>
                </Box>
            </Box>
            {
                openLike && (
                   <Box sx={{ mt: '20px' }}>
                      <Card variant='outlined' sx={{ p: '20px' }}>
                        <Typography>좋아요 {board?.likeCount}</Typography>
                        <Box sx={{ m: '20px 0px', display: 'table' }}>
                            {likeList.map((likeUser) => (<LikeListItem likeUser={likeUser} />))}
                        </Box>
                    </Card>
                   </Box>
            )}

            <Box>
                {
                    openComment && (
                        <Box>

                            <Box sx={{ p: '20px', mb : '30px' }}>
                                <Typography sx={{ fontSize: '16px', fontWeight: 500 }}>댓글 {boardList.length}</Typography>
                                <Stack sx={{ p: '20px 0px' }} spacing={3.75}>
                                    {viewList.map((commentItem) => (<CommentListItem item = {commentItem as Comment}/>))}
                                </Stack>
                            </Box>

                            <Divider />
                            <Box sx={{ p: '20px 0px', display: 'flex', justifyContent: 'center' }}>
                                <Pagination page = {pageNumber} count = {getPageCount(boardList, COUNT)} onChange = {(event, value) => onPageHandler(
                                value)}/>
                            </Box>

                            <Box>
                                <Card variant='outlined' sx = {{ p :'20px'}}>
                                    <Input minRows = {3} multiline disableUnderline fullWidth/>
                                    <Box sx = {{ display : 'flex', justifyContent : 'end' }} >
                                        <Button sx = {{ p : '4px 23px', backgroundColor : '#000000', fontSize : '14px', color : '#ffffff', borderRadius : '46px'}}>댓글 달기</Button>
                                    </Box>
                                </Card>
                            </Box>
                        </Box>
                    )
                }

            </Box>
        </Box>
    )
}
