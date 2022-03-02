import React from 'react'
import './css/button.css'

const Button = ({btnText}) => {
  return (
    <button className='btnComponent' type='button'>{btnText}</button>
  )
}

export default Button