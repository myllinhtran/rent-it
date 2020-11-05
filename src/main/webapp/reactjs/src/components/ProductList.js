import React, {Component} from 'react';
import {Card, CardColumns} from 'react-bootstrap';
import axios from 'axios';
import Bob from './img/Bob.png';
import {Link} from "react-router-dom";


class ProductList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };
    };

    componentDidMount() {
        this.getProducts();
    };

    getProducts = () => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/products")
            .then(response => {
                if (response.data != null) {
                    this.setState({products: response.data})
                }
            });
    };

    render() {

        return (
            <div align={"center"} style={{margin: "20px 60px 60px 60px"}}>
                <CardColumns>
                    {
                        this.state.products.map((product) => {
                                return (
                                    <Card className="border border-grey bg-light text-dark"
                                          key={product.id}
                                          style={{width: '20rem', margin: "0px 15px 15px 0"}}>
                                        <Card.Img variant={"top"} src={Bob}/>
                                        <Card.Body>
                                            <Card.Title align={"left"}>{product.pricePerDay} €</Card.Title>
                                            <Card.Text align={"left"}>
                                                <Link to={"/products/detail/" + product.id}
                                                      style={{textDecoration: "none", color: "black"}}>
                                                    {product.name}
                                                </Link>
                                            </Card.Text>
                                        </Card.Body>
                                    </Card>
                                )
                            }
                        )
                    }
                </CardColumns>
            </div>
        );
    }
}

export default ProductList;