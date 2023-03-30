import { useEffect, useState } from "react";
import { GetListResponseDto, GetMyListResponseDto, GetSearchListResponseDto } from "src/apis/response/board";
import { Comment, ICommentItem, IPreviewItem } from "src/interfaces";
import { BOARD_LIST } from "src/mock";

const usePagingHook = (COUNT : number) => {

    const [boardList, setBoardList] = useState<(GetListResponseDto | GetSearchListResponseDto | GetMyListResponseDto | Comment)[]>([]);
    const [viewList, setViewList] = useState<(GetListResponseDto | GetSearchListResponseDto | GetMyListResponseDto | Comment)[]>([]);
    const [pageNumber, setPageNumber] = useState<number>(1);

    //? 한 페이지에 5개의 게시물을 보여주고자 할 때
    //? 배열의 시작 인덱스   5 * pageNumber - 5 → 5 * (pageNumber - 1)
    //? 배열의 마지막 인덱스 5 * pageNumber - 1

    const onPageHandler = (page: number) => { // 동작 후에 작용하는 걸 방지하고 싶다면 변수를 지정해서 사용?
        setPageNumber(page);
        const tmpList: (GetListResponseDto | GetSearchListResponseDto | GetMyListResponseDto | Comment)[] = [];
        const startIndex = COUNT * (page - 1);
        const endIndex = COUNT * page - 1;

        for (let index = startIndex; index <= endIndex; index++) {
            if (boardList.length < index + 1) break;
            tmpList.push(boardList[index]);
        }

        setViewList(tmpList);
    };

    useEffect(() => { // 처음에 한 번은 무조건 돌고 대괄호안에 상태가 변하면 또 실행
        onPageHandler(pageNumber);
    }, [boardList])

    return { COUNT, boardList, viewList, pageNumber, onPageHandler, setBoardList }; // 중괄호 반환하면 객체로 받아서 무조건 그 이름으로 사용
    // 대괄호는 이름 바꿔서 사용할 수 있음
}

export default usePagingHook;