import React, {useState, useEffect} from 'react'
import axios from 'axios'

import Input from '../Components/Input'
import Navbar from '../Components/Navbar'

import './css/login.css'
import Button from '../Components/Button'

const Login = () => {
    return (
        <>
            <Navbar/>
            <div className='login__container'>  
                <h1 className='login__container-title'>
                    Sign in and start booking!
                </h1>
                <div className='login__container-title--dash'></div>
                <Input label='Username' type='text'/>
                <Input label='Password' type='password'/>
                <div className='login__container-rememberMe'>
                    <input type="checkbox" className="rememberMe" name="rememberMe"/>
                    <label for="rememberMe"> Remember me?</label>
                </div>
                    <Button btnText='Login'/>
                
            </div>          
        </>  
    )
}

export default Login