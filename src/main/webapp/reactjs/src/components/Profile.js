import React, {Component} from 'react';
import {Tabs, TabPane} from "react-bootstrap";
import RentedProducts from "./RentedProducts";
import axios from "axios";
import Account from "./Account";


class Profile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            activeTab: props.activeTab || 1
        };

        this.handleSelect = this.handleSelect.bind(this);
    }

    componentDidMount() {
        const accountId = this.props.match.params.id;
        if (accountId) {
            this.findAccountById(accountId);
        }
    };

    findAccountById = (accountId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/accounts/" + accountId)
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
                <Tabs defaultActiveKey={"account"} onSelect={this.handleSelect} transition={false}>
                    <TabPane eventKey={"account"} title={"Account"}>
                        <Account
                            id={id}
                            firstName={firstName}
                            lastName={lastName}
                            mobile={mobile}
                            email={email}
                        />
                    </TabPane>
                    <TabPane eventKey={"rentedProducts"} title={"Rented Products"}>
                        <RentedProducts/>
                    </TabPane>
                </Tabs>
            </div>
        );
    }
}

export default Profile;