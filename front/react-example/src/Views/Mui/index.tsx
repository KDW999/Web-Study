import Button from '@mui/material/Button'
import React, { useState } from 'react'
import DeleteIcon from '@mui/icons-material/Delete';
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';
import IconButton from '@mui/material/IconButton';
import AlarmOutlinedIcon from '@mui/icons-material/AlarmOutlined';
import { IconButtonProps } from '@mui/material/IconButton';
import { createTheme, styled, ThemeProvider } from '@mui/material/styles';
import { Box, Grid, TextField } from '@mui/material';

//# MUI
//? Material User Interface
//? 구글의 머터리얼 디자인을 구현하는 오픈소스 '리액트 컴포넌트' 라이브러리
//? Install 즉시, 배포 환경에서 사용할 수 있는 사전 구축된 컴포넌트의 모음
//? 디자인적으로 아름답고 다양한 사용자 정의 옵션을 제공
//? npm install @mui/material @emotion/react @emotion/styled로 설치해줘야 사용 가능

//# Mui Styled Method
//? mui component들의 style을 지정해주는 메서드
const CustomIconButton = styled(IconButton)<IconButtonProps>(({ theme }) => ({
    color: theme.palette.primary.dark
}));

//# Mui createTheme method
//? mui theme를 생성하는 메서드
const theme = createTheme({
    palette: {
        primary: {
            main: '#ffff00'
        },
        secondary: {
            main: '#00ff00'
        }
    }
});

const CustomIconButton2 = styled(IconButton)<IconButtonProps>(() => ({
    color: theme.palette.secondary.main
}));
export default function Mui() {

    const [buttonDisabled, setButtonDisabled] = useState<boolean>(true);

    return (
        <>
            {/*
    //# Button Component
    //? import Button from '@mui/material/Button'
    //? import {Button} from '@mui/material/'

    //^ Props
    //^ 1. variant : 버튼의 형태 ('text', 'contained', 'outlined');
    //? text : 문자로만 표기한 버튼
    //? contained : 배경색이 지정된 버튼
    //? outlined : 테두리만 지정된 버튼

    */}
            <Button variant='text'>Text Button</Button>
            <Button variant='contained'>Contained Button</Button>
            <Button variant='outlined'>Outlined Button</Button>

            {/*
    //? Mui의 Button Component는 기본적으로 inline 방식
    //^ 2. fullWidth
    //? Button Component를 Block 형태로 지정 (가로 사이즈 100%)
     */}
            <Button fullWidth>Full Width Button</Button>

            {/*
    //^ 3. disabled
    //? 버튼을 사용하지 못하도록 막아주는 Props
     */}
            <Button variant='contained' disabled={true}>Disable  true Button</Button>
            <Button variant='contained' disabled={false}>Disalbe false Button</Button>

            <Button variant='contained' disabled={buttonDisabled} fullWidth>Disable Button</Button>
            <Button onClick={() => setButtonDisabled(!buttonDisabled)}>Click</Button>

            {/*
     //^ 4. size
     //? Button size를 Mui에서 지정되어있는 사이즈로 지정할 때
     //? small, medium, large
     */}
            <Button variant='contained' size='small'>Small Button</Button>
            <Button variant='contained' size='medium'>Medium Button</Button>
            <Button variant='contained' size='large'>Large Button</Button>

            {/*
     //^ 5. Icon (startIcon, endIcon)
     //? Button 내부에 시작 혹은 종료 지점에 Icon을 추가하고 싶을 때 지정
     //? 값 : Icon Component
     //! npm install @mui/icons-material 추가해야 Icon 사용
      */}

            <Button variant='outlined' startIcon={(<DeleteIcon />)}>Delete</Button>
            <Button variant='contained' endIcon={(<SearchOutlinedIcon />)}>Search</Button>
            {/*
      //# IconButton
      //? Button을 Icon으로만 구성하고자 할 때 사용하는 컴포넌트
      //? Button Component의 모든 기능을 동일하게 사용 가능
      //? 자식 컴포넌트에 Icon Component가 와야함
      //? import { IconButton } from '@mui/material';
      //? import Iconbutton from '@mui/material/IconButton';
      */}
            <IconButton>
                <AlarmOutlinedIcon />
            </IconButton>

            {/*
      //^ Color
      //? default, primary, sucess..
      */}
            <IconButton color='primary'>
                <AlarmOutlinedIcon />
            </IconButton>
            <IconButton color='error'>
                <AlarmOutlinedIcon />
            </IconButton>
            {/*
      //^ Color Customization
      */}
            <CustomIconButton>
                <AlarmOutlinedIcon />
            </CustomIconButton>

            <CustomIconButton2>
                <AlarmOutlinedIcon />
            </CustomIconButton2>

            {/*
            //# ThemeProvider Component
            //? createTheme 메서드로 생성한 커스텀 테마를
            //? 해당 컴포넌트 자손들에게 모두 적용되도록 하는 컴포넌트
            */}
            <ThemeProvider theme={theme}>
                <IconButton color='primary'>
                    <AlarmOutlinedIcon />
                </IconButton>
            </ThemeProvider>
            <br/>
            {/*
            //# TextField Component
            //? HTML의 input 태그를 응용해서 조금 더 수월하게 사용할 수 있도록한 컴포넌트
            //? import { TextField } from '@mui/material';
            //? import TextField from '@mui/material/TextField';
            //^ Props
            //^ 1. variant
            //? 값 : 'outlined', 'filled', 'standard'
            */}
            <TextField variant='outlined'/>
            <TextField variant='filled'/>
            <TextField variant='standard'/>
            {/*
            //^ 2. label
            //? 해당 TextField의 제목을 나타냄
            //? 해당 TextField의 Placeholder 역할
            */}
            <TextField label ='Email' variant = 'outlined'/>
            {/*
            //^ 3. defaultValue
            //? 기본 값 지정
            //^ 4. required
            //? 해당 Component에 필수록 값을 입력해야함
            //^ 5. disabled
            //? 해당 Component를 사용 불가능으로 만듦
            //^ 6. helperText
            //? 해당 Component 아래에 설명을 추가함
        */}
        <TextField label = 'defaultValue' variant='outlined' defaultValue = 'Default'/>
        <TextField label = 'required' variant='outlined' required = {true}/>
        <TextField label = 'dsiabled' variant='outlined' disabled = {true}/>
        <TextField label = 'helperText' variant='outlined' helperText = 'This is HelperText'/>

        {/*
        //# Box Component
        //? HTML의 div태그와 일맥상통
        //? import { Box } from '@mui/material';
        //? import Box from '@mui/material/Box';
        //^ Props
        //^ 1. component
        //? Box Component의 속성을 변경 - 모든 HTML 태그로 변경
        */}
        <Box component= 'h3'>Hello MUI</Box>
        <Box component= {'a'} href = "https://www.naver.com">Go to Naver</Box>

        {/*
        //# Grid Component
        //? 공간을 12등분하여 자식 item을 구분
        //? 반응형 웹 구현에 기준
        //? import { Grid } from '@mui/material';
        //? import Grid from '@mui/material/Grid';
        //^ Propss
        //^ 1. container
        //? 해당 Component의 자식을 12등분으로 나눠줌 / width를 등분하는 듯?
        //^ 2. item
        //? 12등분으로 나눠진 공간에 배치될 요소
        //^ 3. spacing
        //? item간의 간격 지정 - container로 지정된 Grid Component 사용
        //^ 4. xs, sm, md, lg, xl
        //? xs - 600x > width
        //? sm - 600px <= width
        //? md - 900px <= width
        //? lg - 1200px <= width
        //? xl - 1536px <= width
        */}
        <Grid container spacing = {1}>
            <Grid item xs = {11} md = {6} xl = {4}>
                <Box sx= {{height : '100px', backgroundColor : 'red'}}></Box>
            </Grid>
            <Grid item xs = {12} md = {6} xl = {4}>
                <Box sx= {{height : '100px', backgroundColor : 'blue'}}></Box>
            </Grid>
            <Grid item xs = {12} md = {12} xl = {4}>
                <Box sx= {{height : '100px', backgroundColor : 'green'}}></Box>
            </Grid>
        </Grid>
        </>
    )
}
