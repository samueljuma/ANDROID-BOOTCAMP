## Avoid returning or operating on Unit?
> Prefer Boolean instead 

## Specify the variable type when it is not clear

> Do not change scope receiver just because you can. It might be
confusing to have too many receivers all giving us methods we can
use. Explicit argument or reference is generally better. When we
do change receiver, using explicit receivers improves readability
because it clarifies where does the function come from. We can
even use a label when there are many receivers to clarify from
which one the function comes from. If you want to force using
explicit receivers from the outer scope, you can use DslMarker
meta-annotation.