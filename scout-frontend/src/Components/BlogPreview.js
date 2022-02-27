import React from 'react'
import './css/blogPreview.css';

const BlogPreview = () => {
    return (
        <div className='blogPreview__container'>
            <div className='blogPreview__container__title'>
                <p className='blogPreview__container__title-text'>
                    There is a lot more to this world. Start by exploring it only from a click away!
                </p>
                <button type='button'>Read our Blog</button>
            </div>
        </div>
    )
}

export default BlogPreview;