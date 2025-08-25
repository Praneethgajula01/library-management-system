package com.library.repository;

import com.library.model.Member;
import java.util.*;

public class InMemoryMemberRepository implements Repository<Member> {
    private Map<String, Member> members = new HashMap<>();

    @Override
    public void add(Member member) {
        members.put(member.getMemberId(), member);
    }

    @Override
    public void remove(String id) {
        members.remove(id);
    }

    @Override
    public Member findById(String id) {
        return members.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }
}
