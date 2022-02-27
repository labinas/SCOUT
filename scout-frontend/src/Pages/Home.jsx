import React from 'react'
import {Header, Footer, BlogPreview} from '../Components';
import {PopularHotelsContainer, TopRatedContainer, BrowseTypeContainer} from '../Containers';
import './css/home.css';
import './css/calendar.css';


const Home = () => {
    return (
        <>
            <Header/>
            <div className='content__container'>
                <div className='popularHotels__container'>
                    <p className='popularHotels__container-title'>Top 5 Popular Accommodations</p>
                    <div className='popularHotels__container__hotels'>
                        <PopularHotelsContainer/>
                    </div>
                </div>
                <div className='topRated__container'>
                    <p className='topRated__container-title'>Top 5 Rated Accommodations</p>
                    <div className='topRated__container__rated'>
                        <TopRatedContainer/>
                    </div>
                </div>
                <BlogPreview/>
                <div className='browseType__container'>
                    <p className='browseType__container-title'>Browse Accommodations by Type</p>
                    <div className='browseType__container__types'>
                        <BrowseTypeContainer/>
                    </div>
                </div>
                <Footer/>
            </div>

        </>
    )
}

export default Home;