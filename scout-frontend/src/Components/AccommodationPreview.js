import React from 'react'
import './css/accommodationPreview.css';

const AccommodationPreview = ({id, name, city, country, userRating, currency, price, imageLink}) => {
    return (
        <div className='accommodationPreview__container'>
            <div className='accommodationPreview__container-image'>
                <img src={imageLink}></img>

            </div>
            <div className='accommodationPreview__container-info__title'>
                <p className='accommodationPreview__container-info__title-name'>{name}</p>
                <p className='accommodationPreview__container-info__title-city'>{city}, {country}</p>
            </div>
            <div className='acccommodationPreview__container-info'>

                <div className='acccommodationPreview__container-info__numbers'>
                    <p className='acccommodationPreview__container-info__numbers-price'>
                        <span>from</span>
                        {price} {currency}
                    </p>
                    <p className='acccommodationPreview__container-info__numbers-rating'>⭐{userRating}</p>
                </div>
            </div>

        </div>
    )
}

export default AccommodationPreview;