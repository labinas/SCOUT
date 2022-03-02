import React, { useState, useEffect } from 'react'
import {Link} from 'react-router-dom'
import {AccommodationPreview} from '../Components';
import axios from 'axios';

const PopularHotelsContainer = () => {
    const [hotels, setHotels] = useState([]);

    useEffect(() => {
        axios.get('/api/accommodation/mostpopular')
        .then(res => {
            setHotels(res.data);
        })
    }, []);

    return (
        <>
            {hotels.map((hotel) => {
                let link = "/accommodation/" + hotel.id;
                return <Link to={link}>
                    <AccommodationPreview 
                        key={hotel.id} 
                        name={hotel.name} 
                        city={hotel.city} 
                        country={hotel.country} 
                        userRating={hotel.userRating} 
                        currency={hotel.currency} 
                        price={hotel.price} 
                        imageLink={hotel.imageLink} 
                    />
                    </Link>
            })}
        </>
        
        /*<div className='popular__container'>
            <Link to=''>
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
        </div>*/
    )
}

export default PopularHotelsContainer;