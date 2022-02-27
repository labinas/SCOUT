import React from 'react'
import resort from '../images/accommodation.jpg'
import './css/accommodationPreview.css';

const AccommodationPreview = () => {
    return (
        <div className='accommodationPreview__container'>
            <div className='accommodationPreview__container-image'>
                <img src={resort}></img>

            </div>
            <div className='accommodationPreview__container-info__title'>
                <p className='accommodationPreview__container-info__title-name'>Lukanov Apartments & Guest Rooms</p>
                <p className='accommodationPreview__container-info__title-city'>Skopje</p>
            </div>
            <div className='acccommodationPreview__container-info'>

                <div className='acccommodationPreview__container-info__numbers'>
                    <p className='acccommodationPreview__container-info__numbers-price'>
                        <span>from</span>
                        1,500 MKD
                    </p>
                    <p className='acccommodationPreview__container-info__numbers-rating'>⭐8.7</p>
                </div>
            </div>

        </div>
    )
}

export default AccommodationPreview;