interface ResponseDto {
    board: {
        "boardContent": string,
        "boardImgUrl": string,
        "boardNumber": number,
        "boardTitle": string,
        "boardWriteDatetime": string,
        "commentCount": number,
        "likeCount": number,
        "viewCount": number,
        "writerEmail": string,
        "writerNickname": string,
        "writerProfileUrl": string
    },
    commentList: [
        {
            "boardNumber": number,
            "commentContent": string,
            "commentNumber": number,
            "writeDatetime": string,
            "writeProfileUrl": string,
            "writerEmail": string,
            "writerNickname": string
        }
    ],
    likeList: [
        {
            "boardNumber": number,
            "userEmail": string,
            "userNickname": string,
            "userProfileUrl": string
        }
    ]
}

export default ResponseDto