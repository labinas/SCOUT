import React from 'react'
import './css/typeBlock.css'

const TypeBlock = ({type, image}) => {
    return (
        <div className='typeBlock__container'>
            <div className='typeBlock__container-image'>
                <img src={image}></img>
            </div>
            <div className='typeBlock__container-info'>
                <div className='typeBlock__container-info__title'>
                    <p>{type}</p>
                </div>
            </div>
        </div>
    )
}

export default TypeBlock;