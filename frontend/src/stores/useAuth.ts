import { create } from "zustand"
import {Token, User} from "../../types";
import useAuthLocalStorage from "./useAuthLocalStorage.ts";
type AuthState  ={
    user : User
    token: Token
}

type AuthAction  = {
    setUser: (user: User | null) => void;
    setToken: (token: Token) => void;
    clear: () => void;
}

type AuthStore = AuthState & AuthAction;

export const useAuth = create<AuthStore>((set) => {
    const authLocalStorage = useAuthLocalStorage();
    console.log(authLocalStorage.get())
    return {
        user: null,
        token: authLocalStorage.get(),
        setUser: (user = null ) => set(() => ({user})),
        setToken: (token: Token) => authLocalStorage.set({...token}),
        clear: () => {
            authLocalStorage.clear();
        }
    }
})