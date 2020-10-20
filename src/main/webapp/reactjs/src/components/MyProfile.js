import React, {Component} from 'react';
import {Tabs, Tab} from "react-bootstrap";
import MyProducts from "./MyProducts";
import axios from "axios";
import User from "./User";

class MyProfile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            activeTab: props.activeTab || 1
        };

        this.handleSelect = this.handleSelect.bind(this);
    }

    componentDidMount() {
        const userId = this.props.match.params.id;
        if (userId) {
            this.findAccountById(userId);
        }
    };

    findAccountById = (userId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/users/" + userId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        firstName: response.data.firstName,
                        lastName: response.data.lastName,
                        mobile: response.data.mobile,
                        email: response.data.email
                    })
                }
            })
    };

    handleSelect(selectedTab) {
        this.setState({
            activeTab: selectedTab,
        });
    };

    render() {

        const {id, firstName, lastName, mobile, email} = this.state;

        return (
            <div className={"card-body"}>
                <Tabs defaultActiveKey={"user"} onSelect={this.handleSelect}>
                    <Tab eventKey={"user"} title={"User"}>
                        <User
                            id={id}
                            firstName={firstName}
                            lastName={lastName}
                            mobile={mobile}
                            email={email}
                        />
                    </Tab>
                    <Tab eventKey={"rentedProducts"} title={"Rented Products"}><MyProducts/></Tab>
                </Tabs>
            </div>
        );
    }
}

export default MyProfile;