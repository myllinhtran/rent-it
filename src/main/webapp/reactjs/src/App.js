import React from 'react';
import './App.css';
import {Container, Row, Col} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import About from "./components/About";
import Renters from "./components/Renters";
import Footer from "./components/Footer";
import RenterList from "./components/RenterList";
import ProductList from "./components/ProductList";
import Products from "./components/Products";
import ProductDetail from "./components/ProductDetail";
import MyProfile from "./components/MyProfile";


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
                            <Route path="/renters/edit/:id" exact component={Renters}/>
                            <Route path="/products" exact component={ProductList}/>
                            <Route path="/products/add" exact component={Products}/>
                            <Route path="/products/edit/:id" exact component={Products}/>
                            <Route path="/products/detail/:id" exact component={ProductDetail}/>
                            <Route path="/profile/:id" exact component={MyProfile}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}

export default App;
