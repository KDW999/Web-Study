import { Avatar, Box, Typography, Card } from '@mui/material'
import CardActionArea from '@mui/material/CardActionArea';
import React from 'react'
import { useNavigate } from 'react-router-dom';
import { IPreviewItem } from 'src/interfaces'
import { TypeFormatFlags } from 'typescript'

interface Props {
    item : IPreviewItem;
}

export default function BoardListItem({item} : Props) {

    const navigator = useNavigate();

    return (
        <Card variant = 'outlined' >
            <CardActionArea sx={{display : 'flex', justifyContent : 'space-between', p: '24px', backgroundColor: '#ffffff' }} onClick = {() => navigator(`/board/Detail/${item.boardNumber}`)}>
            <Box>
                <Box sx={{ display: 'flex' }}>
                    <Box sx={{ margin: '8px' }}>
                        <Avatar alt= {item.writerNickname} src= {item.writerProfile} />
                    </Box>
                    <Box>
                        <Typography sx={{ fontSize: '12px', fontWeight: 500, color: "#000000" }}>{item.writerNickname}</Typography>
                        <Typography sx={{ mt: '2px', fontSize: '12px', fontWeight: 400, color: 'rgba(0, 0, 0, 0.7)' }}>{item.writeDate}</Typography>
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
            {item.img && (
            <Box>
                <Box component = 'img' src = {item.img} sx = {{ hegiht : '152px', width : '152px', borderRadius : '5.0%'}}/>
            </Box>
            )}
            </CardActionArea>           
        </Card>
    )
}
