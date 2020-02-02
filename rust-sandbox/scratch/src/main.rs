use std::f64::consts;
mod foo;

fn main() {
    let f = foo::Foo::new("hello");

    let ints = [1, 2, 3];
    let floats = [1.1, 2.1, 3.1];
    let strings = ["hello", "world"];
    let ints_ints = [[1, 2], [10, 20]];
    println!("ints {:?}", ints);
    println!("floats {:?}", floats);
    println!("strings {:?}", strings);
    println!("ints_ints {:?}", ints_ints);

    let tup = (500, 6.4, 1);
    let x = tup.0;
}