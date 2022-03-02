import React, {useState, useEffect} from 'react'
import {RiMenu3Line, RiCloseLine} from 'react-icons/ri';
import {Link} from 'react-router-dom'
import axios from 'axios';
import scoutLogo from '../scout.svg'

import '../Components/css/header.css'


const Navbar = ({classModifier}) => {
    const [isToggled, isToggledSet] = useState(false);

    let toggleMenuClassName = isToggled ? 'header__navbar__toggle-menu scale-up-center' : 'header__navbar__toggle-menu';

    if(typeof classModifier === 'undefined'){
        classModifier = "";
    }

  return (
    <div className={'header__navbar' + classModifier}>
        <div className={'header__navbar__logo' + classModifier}>
                    <img src={scoutLogo} alt='logo'></img>
        </div>
        <div className={'header__navbar__link-buttons' + classModifier}>
                    <Link to='/login'>Sign in</Link>
                    <Link to='/register'>Sign up</Link>
                    <button type='button'>Register accomodation</button>
        </div>
        <div className={toggleMenuClassName}>
            {isToggled
                ?
                <RiCloseLine className='closeButton' fill="#fff" size={27} onClick={() => isToggledSet(false)}/>
                :
                <RiMenu3Line className='openButton' fill="#fff" size={27} onClick={() => isToggledSet(true)}/>}
                {isToggled &&
            <div className='header__navbar__toggle-menu__container'>
                <Link to='#'>Sign in</Link>
                <Link to='#'>Sign up</Link>
                <button type='button'>Register accomodation</button>
            </div>
                }
        </div>
    </div>
  )
}

export default Navbar