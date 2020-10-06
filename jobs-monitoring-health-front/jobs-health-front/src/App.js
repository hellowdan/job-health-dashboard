import React, { Component } from 'react';
import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import ListJobComponent from './components/ListJobComponent.jsx';
import HeaderComponent from './components/HeaderComponent.js';
import FooterComponent from './components/FooterComponent.js';
import AddJobComponent from './components/AddJobComponent.jsx';
import ViewJobComponent from './components/ViewJobComponent.jsx';

function App() {
  return (
    <div>
        <BrowserRouter>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListJobComponent}></Route>
                          <Route path = "/jobs" component = {ListJobComponent}></Route>
                          <Route path = "/add-job/:id" component = {AddJobComponent}></Route>
                          <Route path = "/view-job/:id" component = {ViewJobComponent}></Route>
                          {/* <Route path = "/update-job/:id" component = {UpdateJobComponent}></Route> */}
                    </Switch>
                </div>
              <FooterComponent />
        </BrowserRouter>
    </div>
    
  );
}

export default App;
