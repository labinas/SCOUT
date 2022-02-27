import React from 'react';
import {Route, Link, Routes} from 'react-router-dom';
import {
    Accommodation, AccommodationList, Blog, BlogPost, Dashboard,
    EditAccommodation, Error, Home, Inbox, Login, ManageProfile,
    Register, RegisterAccommodation, Reservations, ReviewList, SavedProperties, WriteBlogEntry
} from './Pages';
import './App.css';

function App() {
    return (
        <div className='App'>
            <Routes>
                <Route exact path='/accommodation/:id' element={<Accommodation/>}></Route>
                <Route exact path='/search' element={<AccommodationList/>}></Route>
                <Route exact path='/blog' element={<Blog/>}></Route>
                <Route exact path='/blog/post/:id' element={<BlogPost/>}></Route>
                <Route exact path='/dashboard' element={<Dashboard/>}></Route>
                <Route exact path='/edit/:id' element={<EditAccommodation/>}></Route>
                <Route exact path='/' element={<Home/>}></Route>
                <Route exact path='/inbox' element={<Inbox/>}></Route>
                <Route exact path='/login' element={<Login/>}></Route>
                <Route exact path='/manageProfile' element={<ManageProfile/>}></Route>
                <Route exact path='/register' element={<Register/>}></Route>
                <Route exact path='/reservations/:id' element={<Reservations/>}></Route>
                <Route exact path='/myReviews' element={<ReviewList/>}></Route>
                <Route exact path='/saved' element={<SavedProperties/>}></Route>
                <Route exact path='/blog/create' element={<WriteBlogEntry/>}></Route>
                <Route path='*' element={<Error/>}></Route>
            </Routes>

        </div>
    );
}

export default App;
