import React, {useState} from 'react'
import {RiMenu3Line, RiCloseLine} from 'react-icons/ri';
import {SearchBar} from '.';
import {Link} from 'react-router-dom';
import scoutLogo from '../scout.svg'
import Navbar from './Navbar';

import './css/header.css'


const Header = () => {

    /*const [isToggled, isToggledSet] = useState(false);

    let toggleMenuClassName = isToggled ? 'header__navbar__toggle-menu scale-up-center' : 'header__navbar__toggle-menu';*/

    return (
        <div className='header'>
            <Navbar classModifier='--home'/>
            <div className='header__title'>
                <div className='header__title-main'>
                    <p>It's time to</p>
                    <p>Discover!</p>
                </div>
                <p className='header__title-sub'>
                    Find and book a new great experience.
                </p>
            </div>
            <SearchBar/>
        </div>

    )
}

export default Header;