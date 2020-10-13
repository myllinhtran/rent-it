import React from 'react';
import './App.css';
import {Container, Row, Col} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import About from "./components/About";
import Renters from "./components/Renters";
import Categories from "./components/Categories";
import Footer from "./components/Footer";
import RenterList from "./components/RenterList";


function App() {

    let marginTop = {
        marginTop: "20px"
    };

    return (
        <Router>
            <NavigationBar/>
            <Container>
                <Row>
                    <Col lg={12} style={marginTop}>
                        <Switch>
                            <Route path="/" exact component={Welcome}/>
                            <Route path="/about" exact component={About}/>
                            <Route path="/renters" exact component={RenterList}/>
                            <Route path="/renters/add" exact component={Renters}/>
                            <Route path="/categories" exact component={Categories}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}

export default App;
