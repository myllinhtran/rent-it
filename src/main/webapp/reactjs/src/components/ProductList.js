import React, {Component} from 'react';
import {Row, Col, Card, Image} from 'react-bootstrap';
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
                    this.setState({
                        id: response.data.id,
                        name: response.data.name,
                        pricePerDay: response.data.pricePerDay,
                        description: response.data.description,
                        category: response.data.category
                    })
                }
            });
    };

    render() {

        return (
            <div>
                {
                    this.state.products.map((product) => (
                        <Card className="border border-grey bg-light text-dark" key={product.id}
                              style={{margin: "0 0 20px 0"}}>
                            <Row>
                                <Col xs={2} className={"square"}>
                                    <Image
                                        src={Bob}
                                        className={"container"}
                                    />
                                </Col>
                                <Col>
                                    <Card.Body>
                                        <Card.Title>{product.name} {product.category.name}</Card.Title>
                                        <Card.Text>
                                            {product.description}
                                        </Card.Text>
                                    </Card.Body>
                                    <Card.Footer align={"right"}>
                                        <Link to={"/products/detail/" + product.id}>See more</Link>
                                    </Card.Footer>
                                </Col>
                            </Row>
                        </Card>
                    ))
                }
            </div>
        );
    }
}

export default ProductList;