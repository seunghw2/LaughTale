import React from 'react';
import Logo from '../../assets/logo.png';
import {Link} from "react-router-dom";
import AuthButton from "./AuthButton.tsx";
import {useAuth} from "../../stores/useAuth.ts";
import {Role} from "../../constants/Role.ts";

const Header = () => {
    const user = useAuth(state => state.user);
    return (
        <div className="sticky top-0 z-50 w-[100%]">
            <div className="bg-black flex justify-center items-center px-10 relative h-[50px]">
                <div className="absolute left-10 items-center">
                    <Link to={`/home`} className="text-3xl text-white hover:text-gray-800">
                        만화읽기
                    </Link>
                    <Link to={`/analyze`} className="ml-10 text-3xl text-white hover:text-gray-800">
                        만화분석
                    </Link>
                    {user?.role == Role.ADMIN && <Link to={`/admin`} className="ml-10 text-3xl text-white hover:text-gray-800">
                        관리자페이지
                    </Link>}

                </div>
                <div className="-translate-y-2 center">
                    <Link to="/main">
                        <img src={Logo} alt="Logo" height="200" width="170"></img>
                    </Link>
                </div>
                <div className="absolute right-10">
                    <AuthButton/>
                </div>
            </div>
          </div>
    )
}

export default Header;
