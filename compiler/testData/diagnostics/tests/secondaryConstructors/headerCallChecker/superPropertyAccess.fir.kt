// !DIAGNOSTICS: -UNUSED_PARAMETER
open class B(val prop: Int)
class A : B {
    constructor(x: Int, y: Int = <!TYPE_MISMATCH!>x + <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>prop<!> <!OVERLOAD_RESOLUTION_AMBIGUITY!>+<!> <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>.prop + <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>super<!>.prop<!>) :
        super(<!ARGUMENT_TYPE_MISMATCH!>x + <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>prop<!> <!OVERLOAD_RESOLUTION_AMBIGUITY!>+<!> <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>.prop + <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>super<!>.prop<!>)
}
