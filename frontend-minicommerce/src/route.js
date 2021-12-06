import React from "react";
import {Route, Switch, Redirect} from "react-router-dom";
import ItemList from "./containers/itemlist";
import Cart from "./containers/cart"

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/itemlist" component={ItemList} />
                <Route exact path="/cart" component={Cart} />
                <Route exact path="/">
                    <Redirect to="itemlist"/>
                </Route>
            </Switch>
        </div>
    );
};