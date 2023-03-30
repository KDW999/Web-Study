import { Box, Grid, Pagination, Typography } from '@mui/material'
import { Stack } from '@mui/system';
import axios, { AxiosResponse } from 'axios';
import React, { useEffect, useState } from 'react'
import ResponseDto from 'src/apis/response';
import { GetListResponseDto } from 'src/apis/response/board';
import BoardListItem from 'src/components/BoardListItem'
import PopularCard from 'src/components/PopularCard'
import { GET_LIST_URL } from 'src/constants/api';
import { usePagingHook } from 'src/hooks';
import { IPreviewItem } from 'src/interfaces';
import { BOARD_LIST } from 'src/mock';
import { getPageCount } from 'src/utils';

export default function MainContents() {

  const { viewList, boardList, COUNT, pageNumber, onPageHandler, setBoardList } = usePagingHook(5); 

  const getList = () => {
    axios.get(GET_LIST_URL)
    .then( (response) => getListResponseHandler(response))
    .catch( (error) => getListErrorHandler(error));
  }

  const getListResponseHandler = (response : AxiosResponse<any, any>) => {
    const { result, message, data } = response.data as ResponseDto<GetListResponseDto[]>;

    if(!result || data === null) return;
    setBoardList(data); 
  }

  const getListErrorHandler = (error : any) => {

    console.log(error.message);
  }
  useEffect(() => {
    getList()
  }, [])

  return (
    <Box sx={{ p: '40px 120px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
      <Box>
        <Typography sx={{ fontSize: '24px', fontWeight: 500 }}>최신 게시물</Typography>
      </Box>

      <Box sx={{ pt: '20px', pb: '80px' }}>
        <Grid container spacing={3}>
          <Grid item sm={12} md={8}>
            <Stack spacing={2}>
              {viewList.map((boardItem) => (<BoardListItem item={boardItem as GetListResponseDto} />))}
            </Stack>
          </Grid>
          <Grid item sm={12} md={4}>
            <PopularCard title="인기 검색어" />
          </Grid>
        </Grid>
      </Box>

      <Box sx={{ display: 'flex', justifyContent: 'center' }}>
        <Pagination page={pageNumber} count={getPageCount(boardList, COUNT)} onChange={(event, value) => onPageHandler(value)} />
      </Box>
    </Box>

  )
}
