# 设计模式



# 设计模式

> 本工程尝试编写完整的23个设计模式案例
>
> 面向对象
>
> MVC贫血模型&充血模型



为啥要用设计模式



### 设计原则

SOLID:

S：单一职责原则：一个类一个职责，不做复用；

O：开闭原则，对扩展开放，对修改关闭，已经存在的类，尽量不修改，减少回归测试；

L：里氏替换原则，类多态（判断依据：父类的测试案例，子类完全可以执行成功）[**TODO:待完善**]

D：依赖倒置原则，依赖反转，由框架驱动流程，而不是自己写`面向过程`的代码；

I：接口隔离原则，接口扩展，不依赖过多的接口功能，采用扩展的方式扩展功能；

L：迪米特法则：[待完善]



### 类和对象之间的关系









设计模式总归23种，按照功能分为3类：创建型、结构型、动作型。

按照模式适用的内容分为：`对象`型和`类`型。

| 范围\目的 | 创建型模式                | 结构型模式                                  | 行为型模式                                               |
| --------- | ------------------------- | ------------------------------------------- | -------------------------------------------------------- |
| 类模式    | 工厂方法                  | (类）适配器                                 | 模板方法、解释器                                         |
| 对象模式  | 单例 原型 抽象工厂 建造者 | 代理 (对象）适配器 桥接 装饰 外观 享元 组合 | 策略 命令 职责链 状态 观察者 中介者 迭代器 访问者 备忘录 |



#### 创建型模式
> 该类型的模式用于创建一个新对象，主要有4种

主要包括：

- 单例模式(饱汉式，饿汉式，线程安全等)
- 工厂模式(简易工厂模式，工厂方法模式，抽象工厂模式)
- 建造者模式：Builder，用于创建单个复杂的类
- 原型模式：




#### 结构型模式

> 结构型模式(Structural model)描述如何将类或对象按某种布局组成更大的结构。
>
> 它分为类结构型模式和对象结构型模式，前者采用继承机制来组织接口和类，后者釆用组合或聚合来组合对象。

结构型模式分为以下 7 种：
1. 代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
2. 适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
3. 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现的，从而降低了抽象和实现这两个可变维度的耦合度。
4. 装饰（Decorator）模式：动态地给对象增加一些职责，即增加其额外的功能。
5. 外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
6. 享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
7. 组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。





#### 行为型模式

> 该类模式，用于组织类和对象的行为方式。
>
>



总归23种设计模式：

| 设计模式 | 简述  | 一句话归纳  | 目的  | 生活案例 |
| ----- | ---- | ---------- | ----- | ------- | 
|  工厂模式（Factory Pattern） | 不同条件下创建不同实例  | 产品标准化，生产更高效         | 封装创建细节 | 实体工厂       |
| 单例模式（Singleton Pattern）                 | 保证一个类仅有一个实例，并且提供一个全局访问点               | 世上只有一个我                                             | 保证独一无二                   | CEO          |                |
| 原型模式（Prototype Pattern）                 | 通过拷贝原型创建新的对象                                     | 拔一根猴毛，吹出千万个                                     | 高效创建对象                   | 克隆         |                |
| 建造者模式（Builder Pattern）                 | 用来创建复杂的复合对象                                       | 高配中配和低配，想选哪配就哪配                             | 开放个性配置步骤               | 选配         |                |
| 代理模式（Proxy Pattern）                                    | 为其他对象提供一种代理以控制对这个对象的访问               | 没有资源没时间，得找别人来帮忙 | 增强职责     | 媒婆           |
| 外观模式（Facade Pattern）                    | 对外提供一个统一的接口用来访问子系统                         | 打开一扇门，通向全世界                                     | 统一访问入口                   | 前台         |                |
| 装饰器模式（Decorator Pattern）               | 为对象添加新功能                                             | 他大舅他二舅都是他舅                                       | 灵活扩展、同宗同源             | 煎饼         |                |
| 享元模式（Flyweight Pattern）                 | 使用对象池来减少重复对象的创建                               | 优化资源配置，减少重复浪费                                 | 共享资源池                     | 全国社保联网 |                |
| 组合模式（Composite Pattern）                 | 将整体与局部（树形结构）进行递归组合，让客户端能够以一种的方式对其进行处理 | 人在一起叫团伙，心在一起叫团队                             | 统一整体和个体                 | 组织架构树   |                |
| 适配器模式（Adapter Pattern）                 | 将原来不兼容的两个类融合在一起                               | 万能充电器                                                 | 兼容转换                       | 电源适配     |                |
| 桥接模式（Bridge Pattern）                    | 将两个能够独立变化的部分分离开来                             | 约定优于配置                                               | 不允许用继承                   | 桥           |                |
| 模板模式（Template Pattern）                                 | 定义一套流程模板，根据需要实现模板中的操作                 | 流程全部标准化，需要微调请覆盖 | 逻辑复用     | 把大象装进冰箱 |
| 策略模式（Strategy Pattern）                  | 封装不同的算法，算法之间能互相替换                           | 条条大道通罗马，具体哪条你来定                             | 把选择权交给用户               | 选择支付方式 |                |
| 责任链模式（Chain of Responsibility Pattern） | 拦截的类都实现统一接口，每个接收者都包含对下一个接收者的引用。将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。 | 各人自扫门前雪，莫管他们瓦上霜                             | 解耦处理逻辑                   | 踢皮球       |                |
| 迭代器模式（Iterator Pattern）                | 提供一种方法顺序访问一个聚合对象中的各个元素                 | 流水线上坐一天，每个包裹扫一遍                             | 统一对集合的访问方式           | 逐个检票进站 |                |
| 命令模式（Command Pattern）                   | 将请求封装成命令，并记录下来，能够撤销与重做                 | 运筹帷幄之中，决胜千里之外                                 | 解耦请求和处理                 | 遥控器       |                |
| 状态模式（State Pattern）                     | 根据不同的状态做出不同的行为                                 | 状态驱动行为，行为决定状态                                 | 绑定状态和行为                 | 订单状态跟踪 |                |
| 备忘录模式（Memento Pattern）                 | 保存对象的状态，在需要时进行恢复                             | 失足不成千古恨，想重来时就重来                             | 备份、后悔机制                 | 草稿箱       |                |
| 中介者模式（Mediator Pattern）                | 将对象之间的通信关联关系封装到一个中介类中单独处理，从而使其耦合松散 | 联系方式我给你，怎么搞定我不管                             | 统一管理网状资源               | 朋友圈       |                |
| 解释器模式（Interpreter Pattern）             | 给定一个语言，定义它的语法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子 | 我想说”方言“，一切解释权都归我                             | 实现特定语法解析               | 摩斯密码     |                |
| 观察者模式（Observer Pattern）                | 状态发生改变时通知观察者，一对多的关系                       | 到点就通知我                                               | 解耦观察者与被观察者           | 闹钟         |                |
| 访问者模式（Visitor Pattern）                 | 稳定数据结构，定义新的操作行为                               | 横看成岭侧成峰，远近高低各不同                             | 解耦数据结构和数据操作         | KPI考核      |                |
| 委派模式（Delegate Pattern）                                 | 允许对象组合实现与继承相同的代码重用，负责任务的调用和分配 | 这个需求很简单，怎么实现我不管 | 只对结果负责 | 授权委托书     |





参考内容：

1. 王争 极客时间《设计模式》课程；
2. [设计模式教程网站](http://c.biancheng.net/view/8507.html)
3. GoF 《设计模式》[*最经典的书*]

