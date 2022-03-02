import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter} from 'react-router-dom';
import History from './History';

import App from './App';
import './index.css';

axios.defaults.baseURL = 'http://localhost:8080';

ReactDOM.render(<BrowserRouter history={History}>
    <App/>
</BrowserRouter>, document.getElementById('root'));
