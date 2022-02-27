import React from 'react'
import {Link} from 'react-router-dom'
import {AccommodationPreview} from '../Components';

const PopularHotelsContainer = () => {
    return (
        <div className='popular__container'>
            <Link to='#'>
                <AccommodationPreview/>
            </Link>
            <Link to='#'>
                <AccommodationPreview/>
            </Link>
            <Link to='#'>
                <AccommodationPreview/>
            </Link>
            <Link to='#'>
                <AccommodationPreview/>
            </Link>
            <Link to='#'>
                <AccommodationPreview/>
            </Link>
        </div>
    )
}

export default PopularHotelsContainer;