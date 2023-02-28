import { stringify } from 'querystring';
import React from 'react'

//? Props - Properties
interface DateProps {
    placeholder: string;
}
function DateInputGroup( {placeholder} : DateProps) {
    return (
        <div className="flex-1">
            <input
                className="input-middle-style"
                type="number"
                placeholder={placeholder} />
        </div>
    );
}

function MonthSelectGroup() {
    //# ts에서 배열 선언 및 초기화는 [] 사용, 자바의 ArrayList와 유사한 형태
    const months: number[] = [];
    for (let i = 1; i <= 12; i++)
        months.push(i);

    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    return (
        <div className="flex-1">
            {/* select */}
            <select className="input-middle-style">
                <option>월</option>
                {months.map((month) => (
                    <option>{month}</option>
                ))}
            </select>
        </div>
    )
}
//! 함수형 컴포넌트의 첫 글자는 반드시 대문자여야 한다.
export default function BirthInputGroup() {
    return (
        <div className="content">
            <div className="input-label">생년월일</div>
            <div className="flex">
                {/* stlye display 요소를 inline으로 적용해서 바꿔줌*/}
                <DateInputGroup placeholder='년 (4자리)' />
                <MonthSelectGroup />
                <DateInputGroup placeholder='일' />

            </div>
        </div>

    )
}
