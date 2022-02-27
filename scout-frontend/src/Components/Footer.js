import React from 'react'
import './css/footer.css'
import logo from '../scout.svg';


const year = new Date().getFullYear();

const Footer = () => {
    return (
        <div className='footer__container'>
            <div className='footer__container-buttons'>
                <button type='button'>Register accommodation</button>
            </div>
            <hr className='footer__container-line'>

            </hr>
            <div className='footer__container-signature'>
                <div className='footer__container-signature__logo'>
                    <img src={logo} alt='logo'></img>
                </div>
                <div className='footer__container-signature__label'>
                    Created by Labina Ⓒ{year}
                </div>
            </div>
        </div>
    )
}

export default Footer;