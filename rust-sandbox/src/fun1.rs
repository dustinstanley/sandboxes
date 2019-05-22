//pub fn sqr(x: f64) -> f64 {
//    x * x
//}
//
//pub fn by_ref(x: &i32) -> i32 {
//    x + 1
//}

fn main() {
    let ints = [1, 2, 3, 4, 5];
    let slice1 = &ints[0..2];
    let slice2 = &ints[1..];  // open range!

    println!("ints {:?}", ints);
    println!("slice1 {:?}", slice1);
    println!("slice2 {:?}", slice2);
}