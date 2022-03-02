import React, {useState} from 'react'
import Calendar from 'react-calendar'
import Button from './Button';


const SearchBar = () => {
    const [date, setDate] = useState([new Date(), new Date()]);
    const [calendarOpen, setCalendarOpen] = useState(false);
    const [dateIsSet, setDateIsSet] = useState(false);

    const handleDateOnChange = (newDates) => {
        console.log(newDates);
        setDate(newDates);
        setDateIsSet(true);
        setCalendarOpen(false);
    }

    const handleDateButtonClick = () => {
        setCalendarOpen(!calendarOpen);
    }

    return (
        <div className='header__searchBar'>
            <div className='header__searchBar-people'>
                <label>
                    Adults:
                    <input type='number'></input>
                </label>
                <label>
                    Children:
                    <input type='number'></input>
                </label>
            </div>
            <div className='header__searchBar-search'>
                <input type='text' placeholder='📍 Where are you going?'></input>
                <button className='header__searchBar-search-date-button' type='button' onClick={handleDateButtonClick}>
                    {(!dateIsSet || calendarOpen) && "Choose time period"}
                    {!calendarOpen && dateIsSet && (date[0].toDateString() + " - " + date[1].toDateString())}
                </button>

                {date.length > 0 && console.log(date[0], date[1])}
                <Button btnText='Search'/>
            </div>
            {calendarOpen && <Calendar onChange={handleDateOnChange} selectRange={true} value={date}/>}
        </div>
    )
}

export default SearchBar;