import { Box, Card, Grid, Typography } from '@mui/material'
import { textAlign } from '@mui/system'
import axios, { AxiosResponse } from 'axios';
import React, { useEffect, useState } from 'react'
import ResponseDto from 'src/apis/response';
import { GetTop3ListResponseDto } from 'src/apis/response/board';
import PreViewCard from 'src/components/PreviewCard'
import { GET_TOP3_LIST_URL } from 'src/constants/api';
import { IPreviewItem } from 'src/interfaces';
import { TOP3 } from 'src/mock';

export default function MainHead() {

  const [top3List, setTop3List] = useState<GetTop3ListResponseDto[]>([]);

  const getTop3List = () => {
     axios.get(GET_TOP3_LIST_URL)
     .then((response) => getTop3ListResponseHandler(response))
     .catch((error) => getTop3ListErrorHandler(error));
  }

  const getTop3ListResponseHandler = (response : AxiosResponse<any, any>) => {

    const {result, message, data} = response.data as ResponseDto<GetTop3ListResponseDto[]>;
    
    if(!result || data === null) return;
    setTop3List(data);
  }

  const getTop3ListErrorHandler = (error : any) => {

    console.log(error.message);

  }

  useEffect(() => {
    getTop3List();
  }, [])

  return (
    <Box sx = {{ pb : '40px', pl : '120px', pr : '120px'}}>
      {/* 점보트론 텍스트 */}
      <Box sx = {{ pt : '80px', pb : "32px", textAlign : 'center'}}>
        <Typography sx = {{ fontSize : '40px', fontWeight : '400'}}>KDW's Board</Typography>
        <Typography sx = {{ fontSize : '40px', fontWeight : '400'}}>다양한 이야기를 나눠보세요.</Typography>
      </Box>
      {/* 주간 Top3 게시물 */}
      <Box>
        <Typography sx = {{ 
          fontSize : '24px',
          fontWeight : '400', 
          pt : '24px', 
          textAlign : 'center'}}>주간 Top3 게시물</Typography>
        <Grid container spacing = {3}>
          {top3List.map((item) => (
            <Grid item sm = {12} md = {4} >
            <PreViewCard previewItem={item}/>
          </Grid>
          ))}
        </Grid>
      </Box>
    </Box>
  )
}
