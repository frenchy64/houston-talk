# houston-talk

How can we deal with typed/untyped interaction?

## Situation

Our language boundary between typed and untyped is as the dotted line below.

```
Typed land

houston-talk.problem.typed

-----------------------------

Untyped land

houston-talk.problem.untyped
```

`houston-talk.problem.untyped` 
imports code from 
`houston-talk.problem.untyped`, 
so we need to safely
import the untyped vars such that the type system is not violated by untyped code.


## Approach 1: fully typed

The first approach is simple to think about. Simply convert
`houston-talk.approach1.untyped` 
to be fully typed 
and 
`houston-talk.approach1.typed`
uses the inferred _static_ types to determine safe usages of
external vars.

```
Typed land

houston-talk.approach1.typed
houston-talk.approach1.untyped

-----------------------------

Untyped land

```

```clojure
(require 'houston-talk.approach1.typed)
```

## Approach 2: import untyped vars with contracts

In this approach, we use `t/untyped-var` to assign expected types to
imported vars.

```
Typed land

houston-talk.approach2.typed

-----------------------------

Untyped land

houston-talk.approach2.untyped
```

For example, in 
`houston-talk.approach2.typed` we write

```clojure
(t/untyped-var u/a t/Int)
```

so that every occurrence of `u/a` is converted to 

```clojure
(cast Int u/a)
```

Notice, we can import vars to more sophisticated types, such as `[Int :-> Int]`.

# Approach 3: fully dynamic

We can also relax the checking in our typed module.

```
Typed land


-----------------------------

Untyped land

houston-talk.approach3.typed
houston-talk.approach3.untyped
```

In the typed module we use the use the `:runtime-check` feature to convert our annotations
to runtime checks.

# Approach 4: let core.typed infer good annotations for us

This is not in core.typed 0.3.19, but <a href="https://www.youtube.com/watch?v=zcxOWE7MuOY"> here is a demo</a>.

We basically ask core.typed to give us the annotations needed for approach 2.

We could feasibly always use this approach, but it breaks soundness (untyped vars can now flow anywhere!).

## License

Copyright © 2015 Ambrose Bonnaire-Sergeant

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
