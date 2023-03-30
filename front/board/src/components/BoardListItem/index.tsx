import { Avatar, Box, Typography, Card } from '@mui/material'
import CardActionArea from '@mui/material/CardActionArea';
import React from 'react'
import { useNavigate } from 'react-router-dom';
import { GetListResponseDto, GetSearchListResponseDto } from 'src/apis/response/board';
import { IPreviewItem } from 'src/interfaces'
import { TypeFormatFlags } from 'typescript'

interface Props {
    item : GetListResponseDto | GetSearchListResponseDto; // 데이터 타입의 내용물이 같아서 같은 것으로 인식하나 구분을 위해 타입을 일단 다 적어줌
}

export default function BoardListItem({item} : Props) {

    const navigator = useNavigate();

    return (
        <Card variant = 'outlined' >
            <CardActionArea sx={{display : 'flex', justifyContent : 'space-between', p: '24px', backgroundColor: '#ffffff' }} onClick = {() => navigator(`/board/Detail/${item.boardNumber}`)}>
            <Box>
                <Box sx={{ display: 'flex' }}>
                    <Box sx={{ margin: '8px' }}>
                        <Avatar alt= {item.writerNickname} src= {item.writerProfileUrl ? item.writerProfileUrl : ""} />
                    </Box>
                    <Box>
                        <Typography sx={{ fontSize: '12px', fontWeight: 500, color: "#000000" }}>{item.writerNickname}</Typography>
                        <Typography sx={{ mt: '2px', fontSize: '12px', fontWeight: 400, color: 'rgba(0, 0, 0, 0.7)' }}>{item.boardWriteDatetime}</Typography>
                    </Box>
                </Box>

                <Box sx={{ mt: '16px', mb: '16px' }}>
                    <Typography sx={{ fontSize: '16px', fontWeight: 500, color: '#000000' }}>{item.boardTitle}</Typography>
                    <Typography sx={{ mt: '5px', fontSize: '12px', fontWeight: 400, color: 'rgba(0, 0, 0, 0.7)' }}>{item.boardContent}</Typography>
                </Box>

                <Box>
                    <Typography sx={{ fontSize: '12px', fontWeight: '400', color: 'rgba(0, 0, 0, 0.7)' }}>{`댓글 ${item.commentCount}· 좋아요 ${item.likeCount} · 조회수 ${item.viewCount}`}</Typography>
                </Box>
            </Box>
            {item.boardImgUrl && (
            <Box>
                <Box component = 'img' src = {item.boardImgUrl} sx = {{ hegiht : '152px', width : '152px', borderRadius : '5.0%'}}/>
            </Box>
            )}
            </CardActionArea>           
        </Card>
    )
}
