# SpringCloudServiceProxy
SpringCloudServiceProxy-一个实现代理服务调用层，基于spring cloud，
相比原生spring cloud 不仅做到代码服务层无侵入，
而且服务的参数和返回值 支持 几乎所有复杂对象（依赖与hessian 序列化），调用远程服务像调用本地服务一样方便



demo 运行步骤

step1: 运行 DemoDiscoveryApplication，DemoConsumersApplication，DemoServiceApplication
step2: 浏览器访问 http://localhost:8080/invokeObject 即可 展示 传递复杂对象 的案例。