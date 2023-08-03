package xm.space.array;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/08/03
 * Description:  数组基本实现
 **/
class ArrayImpl {
    private Object[] elementData;

    private int size;

    public ArrayImpl(int capacity){
        elementData = new Object[capacity];
    }

    /**
     * 添加元素
     * @param value
     */
    public void add(Object value){
        if(size >= elementData.length){
            throw new RuntimeException("数组已满，不可添加");
        }
        elementData[size] = value;
        size++;
    }

    /**
     * 查询元素value在数组中的索引位置
     * @param value
     * @return
     */
    public int find(Object value){
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从当前数组中移除首次出现的value元素
     * @param value
     * @return
     */
    public boolean delete(Object value){
        int index = find(value);
        if(index == -1){
            return false;
        }

        for(int i = index;i < size - 1;i++){
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
        return true;
    }

    /**
     * 将数组中首次出现的oldValue替换为newValue
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean update(Object oldValue,Object newValue){
        int index = find(oldValue);
        if(index == -1){
            return false;
        }
        elementData[index] = newValue;
        return true;

    }

    /**
     * 遍历数组中所有数据
     */
    public void print(){
        System.out.print("{");
        for (int i = 0; i < size; i++) {
            if(i == size - 1){
                System.out.println(elementData[i] + "}");
                break;
            }
            System.out.print(elementData[i] + ",");
        }
    }
}
