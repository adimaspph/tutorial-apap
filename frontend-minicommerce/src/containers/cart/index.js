import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";

import { Fab } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';

class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cartItems: [],
            isCheckout: false,
            cartHidden: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            totalHarga : this.price + this.quantity
        }

    }

    render() {
        return (
            <div className={classes.itemList}>
                {/* <a href="itemlist">
                    <Button action={this.handleAddItem}>
                        {`< BACK`}
                    </Button>
                </a> */}
                
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <a href="/itemlist">
                        <Fab variant="extended" onClick={this.handleToggle} >
                            {this.state.cartHidden ? (
                                <Badge
                                    color="secondary"
                                    badgeContent={this.state.cartItems.length}
                                >
                                    <ShoppingCartIcon />
                                </Badge>
                            ) : (
                                <ViewStreamIcon />
                            )}
                        </Fab>
                    </a>
                    
                </div>

                <h1 className={classes.title}>
                    Keranjang
                </h1>


            </div>
        );
    }
}

export default Cart;