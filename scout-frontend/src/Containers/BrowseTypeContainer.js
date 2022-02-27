import React from 'react'
import {TypeBlock} from '../Components';
import {Link} from 'react-router-dom';
import types from '../data/types'

const BrowseTypeContainer = () => {
    return (
        <div className='types__container'>
            {types.map(t => {
                return (
                    <Link to='#'>
                        <TypeBlock key={t.id} {...t}/>
                    </Link>
                );
            })}
        </div>
    );
}

export default BrowseTypeContainer;