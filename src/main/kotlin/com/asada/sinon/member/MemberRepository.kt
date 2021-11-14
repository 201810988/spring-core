package com.asada.sinon.member

interface MemberRepository {
    fun save(member: Member)

    fun findById(memberId: Long): Member?
}