import React from 'react';
import './App.css';
import {Container, Row, Col} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import About from "./components/About";
import Renter from "./components/Renter";
import Footer from "./components/Footer";
import RenterList from "./components/RenterList";
import ProductList from "./components/ProductList";
import Product from "./components/Product";
import ProductDetail from "./components/ProductDetail";
import Profile from "./components/Profile";
import TestProduct from "./components/TestProduct";


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
                            <Route path="/renters/add" exact component={Renter}/>
                            <Route path="/renters/edit/:id" exact component={Renter}/>
                            <Route path="/products" exact component={ProductList}/>
                            <Route path="/products/add" exact component={TestProduct}/>
                            <Route path="/products/edit/:id" exact component={Product}/>
                            <Route path="/products/detail/:id" exact component={ProductDetail}/>
                            <Route path="/profile/:id" exact component={Profile}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}

export default App;
