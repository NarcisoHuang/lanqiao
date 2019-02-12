package org.lanqiao.algo.elementary._09_Linear.list;

/**
 * 单链表
 * ListNode Class 当作数据结构 用来创建对象
 */
public class SingleLinkedList implements MyList {
  private ListNode first; /*前结点*/
  private ListNode last;  /*后结点*/
  private int size;  /*结点的长度*/

  @Override
  public void add(Object element) {
    /**
     * 重构MyArrayList类的add方法
     * 带参数添加结点
     * （1）如果这个SingleLinkedList对象的first变量等于null, 表明这个结点表头
     * 调用ListNode类的带参数的构造方法, 创建一个结点。
     * 将这个结点的地址传递给变量first和last
     *
     * （2）如果结点的前驱结点不是null，表明该结点不是头结点
     * 那么通过ListNode()带参数的构造方法, 创建出一个新的结点
     * 将这个结点的地址赋值给last对象的next属性
     * last = last.next();  这句话将last.next()内保存的地址赋给last这个结点
     *
     * （3）每次执行add()方法都会让size变量加一.
     *
     */
    if (first == null) {
      first = new ListNode(element);
      last = first;
    } else {
      last.next = new ListNode(element);
      last = last.next;
    }
    size++;
  }

  @Override
  public void delete(Object element) {
    /**
     * 通过while()循环语句和if(p.data.equals(element) )判断语句可以使得p找到要删除的元素的位置
     * 但是由于当前的数据结构是单链表, 元素不能向前回溯, 因此只能通过创建一个NodeList对象: pre,
     * 通过这个对象来指向ListNode 对象p的前一个结点对象.
     */
    ListNode p = first;
    ListNode pre = null;
    while (p != null) {
      /**
       * 当p的data的值等于要删除的值时
       * 如果p是头结点, 那么将first结点对象的next中保存的地址赋给first结点对象
       * 如果p不是头结点, 将p.next 结点的地址赋给 pre结点的next.
       * 从而实现了p之前的结点(pre)和p之后的结点(p.next)链接
       * 实现了删除p结点的功能.
       */
      if (p.data.equals(element)) {
        if (p == first) {
          first = first.next;
        } else {
          pre.next = p.next;
        }
        size--;  /*结点数减一*/
        break;   //注意这里, 跳出循环
      }
      /**
       * 先将pre = p; 然后再执行 p = p.next;
       * 实现了pre是p前一个结点 pre和p结点一直沿着链向后移动, 知道p结点就是想要删除的结点
       */
      pre = p;
      p = p.next;
    }
  }

  @Override
  public void delete(int index) {
    if (index < 0 || index >= size) {
      return;//啥也不干
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;
    ListNode pre = null;

    while (p != null) {
      if (i == index) {
        if (p == first)
          first = first.next;
        else
          pre.next = p.next;
        break;//注意这里
      }
      pre = p;
      p = p.next;
      i++;
    }
    size--;
  }

  @Override
  public void update(int index, Object newElement) {
    if (index < 0 || index >= size) {
      return;//啥也不干
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (i == index) {
        p.data = newElement;
      }
      p = p.next;
      i++;
    }
  }

  @Override
  public boolean contains(Object target) {
    ListNode p = first;
    while (p != null) {
      if (p.data.equals(target)) {
        return true;
      }
      p = p.next;
    }
    return false;
  }

  @Override
  public Object at(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (i == index) {
        return p.data;
      }
      p = p.next;
      i++;
    }
    return null;
  }

  @Override
  public int indexOf(Object element) {
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (p.data.equals(element)) {
        return i;
      }
      p = p.next;
      i++;
    }
    return -1;
  }

  @Override
  public String toString() {
    /**
     * 创建p结点变量
     * 通过p遍历链表
     * 通过StringBuilder对象输出p结点的值
     */
    StringBuilder sb = new StringBuilder("[");
    ListNode p = first;
    while (p != null) {
      sb.append(p.data);
      if (p.next != null)
        sb.append(",");
      p = p.next;
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }
}
