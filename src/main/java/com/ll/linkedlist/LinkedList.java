package com.ll.linkedlist;

class ListNode {
    private final String data;
    public ListNode link;

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

public class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        String searchTargetNodeData = "wed";

        // 리스트 마지막에 노드 삽입 * 7일
        linkedList.insertNode("mon");
        linkedList.insertNode("tue");
        linkedList.insertNode("wed");
        linkedList.insertNode("thr");
        linkedList.insertNode("fri");
        linkedList.insertNode("sat");
        linkedList.insertNode("sun");

        //리스트 출력
        linkedList.printList();

        //특정 노드의 값 출력
        System.out.println(linkedList.searchNode(searchTargetNodeData).getData());

        //특정 노드 삭제 후 전체 리스트 출력
        linkedList.deleteNode(linkedList.searchNode(searchTargetNodeData).getData());
        linkedList.printList();

        //특정 노드 검색 후 그 위치에 새로운 노드 삽입
        linkedList.insertNode(linkedList.searchNode("fri"), "KimDongWoo");
        linkedList.printList();

        //첫 노드 삭제 - 첫 노드의 값을 알고 있을 때만 가능
        linkedList.deleteNode("mon");
        linkedList.printList();

    }

    // node 끝에 삽입
    public void insertNode(String data) {
        ListNode freshNode = new ListNode(data); // 삽입할 새로운 노드 생성
        if (head == null) { // head가 null ? head가 될 노드를 참조
            this.head = freshNode;
        } else { // head가 not null ? 헤드가 참조하고 있는 노드들 중 맨 뒤에 노드에 연결해야함
            ListNode tempNode = head; // 헤드를 움직일 수 없으니 임시 노드를 헤드에 연결함

            // 헤드를 참조하고 있는 임시 노드의 끝을 따라가기로함
            // 임시 노드의 끝엔 link가 null을 참조하기에, 끝에 가서 연결하기 위해 끝까지 감
            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }

            //끝까지 간 경우(head가 null이 아닐 때) 내가 삽입할 노드를 연결
            tempNode.link = freshNode;
        }
    }

    // node 중간에 삽입 , ! 중간에 삽입하려면 넣으려는 곳의 아이템 혹은 주소를 알아야함 앞서 언급함
    public void insertNode(ListNode prevNode, String data) {
        // 중간에 삽입할 노드를 새로 생성, 입력받은 data활용
        ListNode freshNode = new ListNode(data);
        // 새로운 노드를 삽입할 위치에 있던 노드가 가리키던 곳의 노드로 연결
        freshNode.link = prevNode.link;
        // 삽입할 위치에 있던 노드를 새로 삽입할 노드에 연결
        prevNode.link = freshNode;
    }

    // 특정 노드 삭제
    public void deleteNode(String deleteTargetNodeData) {
        ListNode prevNode = head; // 현재 노드와
        ListNode tmpNode = head.link; // 다음노드

        if (deleteTargetNodeData.equals(prevNode.getData())) { // 현재 노드의 값과 삭제할 데이터의 값이 같을 때
            head = prevNode.link; // 헤드가 참조하는 첫 노드를 다음 노드로 변경하고
            prevNode.link = null; // 현재 노드의 링크를 없앰(연결고리 제거)
        } else { // 현재 노드의 값과 삭제할 데이터가 다를 때
            while (tmpNode != null) { // 현재 기준으로 다음 노드를 찾아가야함 + 다음 노드가 null 아닐때 게속 반복
                if (deleteTargetNodeData.equals(tmpNode.getData())) { // 다음 노드의 값과 삭제할 데이터와 같을 때
                    if (tmpNode.link == null) { // 다음 노드가 없을 경우 = 마지막 노드
                        prevNode.link = null; // 전 노드 연결고리 제거
                    } else { // 다음 노가 있는 경우
                        prevNode.link = tmpNode.link; //전의 노드를 현재의 노드의 다음의 노드와 연결 시켜줌
                        tmpNode.link = null; // 그리고 현재 노드 삭제
                    }
                    break;
                } else { // 삭제할 데이터가 일치하지 않는 경우
                    prevNode = tmpNode;  // 이전을 현재로
                    tmpNode = tmpNode.link; // 현재를 다음으로 연결시켜 반복
                }
            }
        }
    }

    // node 조회
    public ListNode searchNode(String searchTargetNodeData) {
        ListNode tmpNode = this.head;

        while (tmpNode != null) {
            if (tmpNode.getData().equals(searchTargetNodeData)) {
                return tmpNode;
            } else {
                tmpNode = tmpNode.link;
            }
        }
        return tmpNode;
    }

    // list출력
    public void printList() {
        ListNode tmpNode = this.head;
        while (tmpNode != null) {
            System.out.print(tmpNode.getData() + " ");
            tmpNode = tmpNode.link;
        }
        System.out.println();
    }
}


