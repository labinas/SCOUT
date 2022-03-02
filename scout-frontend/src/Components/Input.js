import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom'
import axios from 'axios';

import './css/input.css'

const Input = ({label, type}) => {
    return (
        <div class="inp">
            <input type={type} id="inp" placeholder="&nbsp;"/>
            <span class="label">{label}</span>
        </div>
    );
}

export default Input;