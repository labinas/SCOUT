import React, {useState} from 'react'
import {RiMenu3Line, RiCloseLine} from 'react-icons/ri';
import {SearchBar} from '.';
import {Link} from 'react-router-dom';
import scoutLogo from '../scout.svg'


const Header = () => {

    const [isToggled, isToggledSet] = useState(false);

    let toggleMenuClassName = isToggled ? 'header__navbar__toggle-menu scale-up-center' : 'header__navbar__toggle-menu';

    return (
        <div className='header'>
            <div className='header__navbar'>
                <div className='header__navbar__logo'>
                    <img src={scoutLogo} alt='logo'></img>
                </div>
                <div className='header__navbar__link-buttons'>
                    <Link to='#'>Sign in</Link>
                    <Link to='#'>Sign up</Link>
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