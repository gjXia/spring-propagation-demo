简要编写和测试Spring事务的传播机制demo

· REQUIRED：如果当前没有事务，就创建一个事务，如果已经存在一个事务，就加入该事务，是Spring默认的事务传播类型
· SUPPORTS：如果当前存在事务，则加入当前事务，如果当前没有事务，就以非事务方法执行
· MANDATORY：如果当前存在事务，则加入当前事务，如果当前事务不存在，则抛出异常
· REQUIRES_NEW：创建一个新事务，如果存在当前事务，则挂起该事务
· NOT_SUPPORTED：始终以非事务方式执行，如果当前操作在一个事务中，就把当前事务挂起，以非事务方式运行，直到操作完成再恢复事务执行
· NEVER：始终以非事务的方式执行，如果当前操作存在事务，则抛出异常
· NESTED：如果当前存在事务时（称之为父事务）会开启一个嵌套事务（称之为一个子事务），在NESTED情况下父事务回滚时，子事务也会回滚；子事务回滚，对子事务捕获异常下，不影响父事务的提交和回滚。如果当前事务不存在时，按照REQUIRED事务传播类型执行。


· 外层、内层均不开启事务
    allNotTransaction()
    无事务操作不受影响

· 外层无事务、内层开启默认事务
    onlySubTransaction()
    仅内层方法操作受事务影响

· 外层开启默认事务、内层无设置事务
    onlySubNotTransaction()
    外层和内层方法操作均受事务影响

· 外层、内层均设置默认事务
    allRequired()
    外层和内层方法操作均受事务影响

· 外层无事务、内层设置SUPPORTS
    onlySubSupports()
    均以无事务方式执行，操作不受影响

· 外层无事务、内层设置MANDATORY
    onlySubMandatory()
    外层以无事务方式操作不受影响，内层方法直接抛出异常

· 外层无事务、内层设置REQUIRES_NEW
    onlySubRequiresNew()
    外层以无事务方式操作不受影响，内层方法操作受事务影响

· 外层无事务、内层设置NOT_SUPPORTED
    onlySubNotSupported()
    均以无事务方式执行，操作不受影响

· 外层无事务、内层设置NEVER
    onlySubNever()
    均以无事务方式执行，操作不受影响

· 外层无事务、内层设置NESTED
    onlySubNested()
    外层以无事务方式操作不受影响，内层方法操作受事务影响

· 外层、内层均设置默认事务（在外层方法中捕获内层异常）
    allRequiredSubTry()
    外层和内层方法操作均受事务影响

· 外层设置默认事务、内层设置SUPPORTS
    requiredSupports()
    外层和内层方法操作均受事务影响

· 外层设置默认事务、内层设置MANDATORY
    requiredMandatory()
    外层和内层方法操作均受事务影响

· 外层设置默认事务、内层设置REQUIRES_NEW
    requiredRequiresNew()
    内层方法执行异常时，外层和内层操作均受事务影响；仅外层方法执行异常时，仅外层操作受事务影响

· 外层设置默认事务、内层设置NOT_SUPPORTED
    requiredNotSupported()
    外层方法操作受事务影响，内层方法以无事务方式操作不受影响

· 外层设置默认事务、内层设置NEVER
    requiredNever()
    内层方法直接抛出异常，外层操作事务回滚

· 外层设置默认事务、内层设置NESTED
    requiredNested()
    外层和内层方法操作均受事务影响；若仅内层方法执行报错，且对外层方法中对内层方法异常进行捕获处理，只回滚内层事务
