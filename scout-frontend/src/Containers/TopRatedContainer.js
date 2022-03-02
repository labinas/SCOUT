import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom'
import {AccommodationPreview} from '../Components';
import axios from 'axios';

const TopRatedContainer = () => {
    const [hotels, setHotels] = useState([]);

    useEffect(() => {
        axios.get('/api/accommodation/toprated')
        .then(res => {
            console.log(res, res.data);
            setHotels(res.data);
        })
    }, []);

    return (
        <div className='popular__container'>
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
        </div>
    )
}

export default TopRatedContainer;