import React from "react";
import Item from "../Item/index.js";
import {IconButton}  from "@material-ui/core";

export default function List({ title, items, onItemClick, isShopList }) {

    // function delete(item) {
    //     item = 
    // }

    return (
        <>
            <h3 style={StyleSheet.heading}>{title}</h3>
            <div className="list-group">
                {items.length === 0 ? (
                    <div className="text-center">
                        <h1>Belum ada item yang dipilih</h1>
                        <h3>Klik salah satu item di List Item</h3>
                    </div>
                ) : null}
                {items.map((item) => (
                    <div>
                        <Item key={item.id} item={item} onChange={onItemClick} isShopList={isShopList}/>
                        {/* <button onClick={delete} item={item}>Delete</button> */}
                    </div>
                ))}
            </div>
        </>
    );
}